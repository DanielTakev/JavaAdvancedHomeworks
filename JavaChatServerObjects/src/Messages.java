import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.sql.Timestamp;

public class Messages implements Serializable {

    private String clientName;
    private String clientMessage;
    private InetAddress clientInetAddress;
    private Timestamp timestamp;
    private byte[] messageUTF8Bytes;
    private static final long serialVersionUID = 1L;

    public Messages(String clientMessage, String clientName, InetAddress clientInetAddress) {
        this.clientMessage = clientMessage;
        this.clientName = clientName;
        this.clientInetAddress = clientInetAddress;
    }

    @Override
    public String toString() {
        timestamp = new Timestamp(System.currentTimeMillis());
        try {
            messageUTF8Bytes = clientMessage.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "Message: " + clientMessage + "\r\n" +
                "Name: " + clientName + "\r\n" +
                "IP Address: " + clientInetAddress + "\r\n" +
                "Message timestamp is: " + timestamp + "\r\n" +
                "Message UTF-8 bytes: " + messageUTF8Bytes.length + "\r\n" +
                "________________";
    }
}
