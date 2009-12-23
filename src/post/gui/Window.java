package post.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public void close(){
        this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
    }
}
