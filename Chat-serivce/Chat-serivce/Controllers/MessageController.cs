using Chat_serivce.Models;
using Chat_serivce.Services;
using Microsoft.AspNetCore.Mvc;

namespace Chat_serivce.Controllers;

[Controller]
[Route("[controller]")]
public class MessageController: Controller {
    
    private readonly MongoDBService _mongoDBService;

    
    public MessageController(MongoDBService mongoDBService) {
        _mongoDBService = mongoDBService;
    }
    
    
    
    [HttpGet]
    public async Task<List<Message>> Get() {
        return await _mongoDBService.GetAsync();
    }
    
    [HttpGet("{id_sender}/{id_receiver}")]
    public async Task<Conversation> GetUser([FromRoute] int id_sender,[FromRoute] int id_receiver) { 
        return await _mongoDBService.GetConversation(id_sender,id_receiver);
    }

    [HttpPost]
    public async Task<IActionResult> Post([FromBody] Message message) {
        await _mongoDBService.CreateAsync(message);
        return CreatedAtAction(nameof(Get), new { id = message.Id }, message);
    }
  
    [HttpDelete("{id}")]
    public async Task<IActionResult> Delete(string id) {
        await _mongoDBService.DeleteAsync(id);
        return NoContent();
    }

}