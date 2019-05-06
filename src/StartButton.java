import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;



public class StartButton extends GraphicsProgram {

    public static final int NUMBER_OF_PLAYERS = 8;
    public static final int TABLE_LENGTH = 360;
    public static final int TABLE_WIDTH = 120;
    public static final int CHAIR_LENGTH = 60;
    public static final int CHAIR_WIDTH = 20;

    public static final int PLACEMAT_RADIUS = 10;

    public static final int TABLE_X = 200;
    public static final int TABLE_Y = 200;

    //public GLabel label;

    public void init(){

        //setLayout(new GridLayout(1,2));
        //GLabel label = new GLabel("Ready to Begin", 10, 10);
       // add(label);
        add(new JButton("Start"), NORTH);
        addActionListeners();

       //
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if (cmd.equals("Start")) {
            //remove(label);
            setupGameBoard();
            runGame();
        }
       //
    }

    public void setupGameBoard(){

        createTable();
        createChairs();
        createPlaceSettings();
    }



    public void runGame (){


        Customer next_customer = generateCustomer ();
       // seatCustomer(next_customer);

    }

    public void createTable(){
        add(new GRect(TABLE_X, TABLE_Y, TABLE_LENGTH, TABLE_WIDTH));
    }

    public void createChairs(){

        int startingPosition_X = TABLE_X + TABLE_LENGTH/NUMBER_OF_PLAYERS - CHAIR_LENGTH/2;
        int startingPosition_Y = TABLE_Y - 2* CHAIR_WIDTH;
        for (int i = 0; i < (NUMBER_OF_PLAYERS/2); i++){
            GRect chair = new GRect(startingPosition_X, startingPosition_Y, CHAIR_LENGTH, CHAIR_WIDTH);
            add(chair);
            chair.setFilled(true);
            chair.setFillColor(Color.GREEN);
            startingPosition_X += TABLE_LENGTH/(NUMBER_OF_PLAYERS/2);
        };

        startingPosition_X = TABLE_X + TABLE_LENGTH/NUMBER_OF_PLAYERS - CHAIR_LENGTH/2;
        startingPosition_Y = TABLE_Y + TABLE_WIDTH + CHAIR_WIDTH;
        for (int i = 0; i < (NUMBER_OF_PLAYERS/2); i++){
            GRect chair = new GRect(startingPosition_X, startingPosition_Y, CHAIR_LENGTH, CHAIR_WIDTH);
            add(chair);
            chair.setFilled(true);
            chair.setFillColor(Color.GREEN);
            startingPosition_X += TABLE_LENGTH/(NUMBER_OF_PLAYERS/2);
        };
    }

    public void createPlaceSettings(){

        int startingPosition_X = TABLE_X + TABLE_LENGTH/NUMBER_OF_PLAYERS - PLACEMAT_RADIUS;
        int startingPosition_Y = TABLE_Y + PLACEMAT_RADIUS;
        int placemat_diameter = 2 * PLACEMAT_RADIUS;
        for (int i = 0; i < (NUMBER_OF_PLAYERS/2); i++){
            GOval placemat = new GOval(startingPosition_X, startingPosition_Y, placemat_diameter, placemat_diameter);
            add(placemat);
            placemat.setFilled(true);
            placemat.setFillColor(Color.GREEN);
            startingPosition_X += TABLE_LENGTH/(NUMBER_OF_PLAYERS/2);
        };

        startingPosition_X = TABLE_X + TABLE_LENGTH/NUMBER_OF_PLAYERS - PLACEMAT_RADIUS;
        startingPosition_Y = TABLE_Y + TABLE_WIDTH - 3*PLACEMAT_RADIUS;
        for (int i = 0; i < (NUMBER_OF_PLAYERS/2); i++){
            GOval placemat = new GOval(startingPosition_X, startingPosition_Y, placemat_diameter, placemat_diameter);
            add(placemat);
            placemat.setFilled(true);
            placemat.setFillColor(Color.GREEN);
            startingPosition_X += TABLE_LENGTH/(NUMBER_OF_PLAYERS/2);
        };
    }

    public Customer generateCustomer (){
        CustomerLinkedList<Customer> customer_list = new CustomerLinkedList<>();

        Customer next_customer = new Customer ();
        add(next_customer.icon, 10, 10);
        customer_list.addFirst(next_customer);
        System.out.println(customer_list.size);
        return next_customer;

    }

}
