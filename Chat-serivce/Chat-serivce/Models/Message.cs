using System.Text.Json.Serialization;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace Chat_serivce.Models;

public class Message {

    [BsonId]
    [BsonRepresentation(BsonType.ObjectId)]
    public ObjectId Id { get; set; }

    public string Text { get; set; }


    public DateTime Timestamp { get; set;  }
    
    public long id_sender { get; set; }
    
    public long id_receiver { get; set; }

}