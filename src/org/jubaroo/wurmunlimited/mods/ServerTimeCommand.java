
package org.jubaroo.wurmunlimited.mods;

import com.wurmonline.server.creatures.Communicator;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.Date;
import java.util.Properties;

public class ServerTimeCommand implements WurmServerMod, PlayerMessageListener, Configurable {
    private int messageRed;
    private int messageGreen;
    private int messageBlue;

    public ServerTimeCommand() {
    }

    public void configure(Properties properties) {
        this.messageRed = Integer.parseInt(properties.getProperty("red"));
        this.messageGreen = Integer.parseInt(properties.getProperty("green"));
        this.messageBlue = Integer.parseInt(properties.getProperty("blue"));
    }

    public boolean onPlayerMessage(Communicator communicator, String message) {
        if (message.startsWith("/stime") || message.startsWith("/servertime")) {
            Date date = new Date();
            communicator.sendServerMessage("Current Server Date and Time Is: " + date, messageRed, messageGreen, messageBlue);
            return true;
        } else {
            return false;
        }
    }

}
