namespace Chat_serivce.Models;

public class Conversation
{
    public string Username_sender { get; set; }
    public string Username_receiver { get; set; }
    public string Role_sender { get; set; }
    public string Role_receiver{ get; set; }
    public List<string> Texts { get; set; }
    public List<DateTime> Timestamp { get; set;  }
}