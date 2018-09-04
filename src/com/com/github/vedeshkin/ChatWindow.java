package com.github.vedeshkin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vedeshkin on 03.09.2018.
 */
public class ChatWindow extends JFrame {

    private JPanel mainPanel;
    private JButton sendMessage;
    private JTextArea chatBox;
    private JTextField messageField;
    private JPanel bottomPanel;
    private com.github.vedeshkin.SendMessageListenerImpl sendMessageListener;

    public static void main(String[] args) {

        ChatWindow chatWindow = new ChatWindow();
    }

    public ChatWindow() {
        init();
    }


    private void init() {
        setTitle("Simple chat application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 500, 500);


        //
        setLayout(new GridLayout(2, 0));
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        //send button
        sendMessage = new JButton("Send");

        //chat box
        chatBox = new JTextArea();
        chatBox.setLineWrap(true);
        chatBox.setVisible(true);
        chatBox.setEditable(false);


        messageField = new JTextField(40);
        mainPanel.add(new JScrollPane(chatBox));

        bottomPanel.add(messageField, BorderLayout.WEST);
        bottomPanel.add(sendMessage, BorderLayout.EAST);
        bottomPanel.setSize(500, 100);

        sendMessageListener = new SendMessageListenerImpl(chatBox, messageField);
        messageField.addActionListener(sendMessageListener);
        sendMessage.addActionListener(sendMessageListener);
        add(mainPanel);
        add(bottomPanel);
        setVisible(true);


    }
}
