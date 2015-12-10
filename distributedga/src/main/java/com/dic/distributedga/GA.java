package com.dic.distributedga;
import java.net.InetAddress;

public class GA {    
    
    public static void main(String[] args) {
    	/*TODO:
    	 * Phase 1
    	 * Write listener and sender class using sockets.
    	 * Sender will be master to send some initial data
    	 * Listeners will wait for command from sender for initial population.
    	 * Listeners will start there calculation and dump result.
    	 * 
    	 * 
    	 * Phase 2. 
    	 * Listeners will send back there result to sender.
    	 * Sender will chose best answer and display.
    	 * 
    	 * Phase 3.
    	 * At periodic interval, sender will send some individuals to listeners.
    	 * Listeners will add that data in there next round of calculation.
    	 * 
    	 * Phase 4.
    	 * Sender will send initial population.
    	 * Sender will send list of all listeners.
    	 * At periodic interval, listeners will send each other some data.
    	 * Listener receiving data from other listener will use it like in phase 3.
    	 * In end, all Listeners will send back there best solution to sender
    	 * Sender will display data.
    	 */
    	
    	System.out.println("starting ga class");
    	for(int i=0;i<args.length;i++){
    		System.out.println("argument "+i+" = "+args[i]);
    	}
    	try{
    	InetAddress address = InetAddress.getLocalHost();
    	System.out.println(address.getHostName()+ " "+address.getHostAddress());
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        if("master".equals(args[0])){
    	System.out.println("inside master ");
        	//eg: java GA master 2 3233
        	MasterGA masterGA = new MasterGA(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        	masterGA.init();
        	masterGA.start();
        }
        else if("slave".equals(args[0])){
    	System.out.println("inside slave");
        	//eg: java GA slave 19.2.4.1 3233
        	SlaveGA slaveGA = new SlaveGA(args[1],Integer.parseInt(args[2]));
        	slaveGA.init();
        	slaveGA.start();
        }
    	System.out.println("exiting");

    }

}