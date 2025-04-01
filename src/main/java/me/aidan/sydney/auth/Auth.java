package me.aidan.sydney.auth;

import me.aidan.sydney.utils.system.Timer;

/**
 * -> Load = 
 */
public class Auth {
    
    /**
     * Init Keys (decrypt- arml - = solo de xor)
     */
    public void Init() {
    }

    /**
     * Send message | discord hook
     * @param msg
     */
    public void sendHook(String msg) {
    }

    /**
     * Dcrypt | String(Cadenas de texto)
     * @return
     */
    public String decrypt() {
        return "";
    }

    /**
     * Return hwid (Pc is - > old)
     * @return
     */
    public String getHwid() {
        return "";
    }

    static Timer timer = new Timer();

    public static void main(String[] args) {
        if (timer.hasTimeElapsed(50000))  {
            System.out.println(timer.timeElapsed());
            timer.reset();
        }
    }
}
