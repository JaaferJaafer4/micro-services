using Chat_serivce.Models;
using Microsoft.Extensions.Options;
using MongoDB.Bson;
using MongoDB.Driver;

namespace Chat_serivce.Services;

public class MongoDBService {

    private readonly IMongoCollection<Message> _messageCollection;
    
    

    public MongoDBService(IOptions<MongoDBSettings> mongoDBSettings) {
        MongoClient client = new MongoClient(mongoDBSettings.Value.ConnectionURI);
        IMongoDatabase database = client.GetDatabase(mongoDBSettings.Value.DatabaseName);
        _messageCollection = database.GetCollection<Message>(mongoDBSettings.Value.CollectionName);
    }

    public async Task<List<Message>> GetAsync() {
        return await _messageCollection.Find(new BsonDocument()).ToListAsync();
    }

    public async Task CreateAsync(Message message)
    {
        await _messageCollection.InsertOneAsync(message);
        return;
    }

    public async Task DeleteAsync(string id) {
        FilterDefinition<Message> filter = Builders<Message>.Filter.Eq("Id", id);
        await _messageCollection.DeleteOneAsync(filter);
        return;
    }
    
    
    public async Task<Conversation> GetConversation(int id_sender, int id_receiver)
    {
        var filter = Builders<Message>.Filter.And(
            Builders<Message>.Filter.Eq("id_sender", id_sender),
            Builders<Message>.Filter.Eq("id_receiver", id_receiver)
        );

        Conversation conversation = new Conversation
        {
            Texts = new List<string>(),
            Timestamp = new List<DateTime>()
        };

        var httpClient = new HttpClient();

        var sender_data = await httpClient.GetAsync("http://localhost:8090/user/" + id_sender);
        var receiver_data = await httpClient.GetAsync("http://localhost:8090/user/" + id_receiver);

        if (sender_data.IsSuccessStatusCode && receiver_data.IsSuccessStatusCode)
        {
            var content_sender = await sender_data.Content.ReadAsStringAsync();
            var sender = Newtonsoft.Json.JsonConvert.DeserializeObject<User>(content_sender);

            var content_receiver = await receiver_data.Content.ReadAsStringAsync();
            var receiver = Newtonsoft.Json.JsonConvert.DeserializeObject<User>(content_receiver);

            conversation.Username_receiver = receiver.Username;
            conversation.Role_receiver = receiver.Role;
            conversation.Username_sender = sender.Username;
            conversation.Role_sender = sender.Role;

            var messages = await _messageCollection.Find(filter).ToListAsync();
            foreach (Message message in messages)
            {
                conversation.Texts.Add(message.Text);
                conversation.Timestamp.Add(message.Timestamp);
            }
        }

        return conversation;
    }


}