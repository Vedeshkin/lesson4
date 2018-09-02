package com.github.vedeshkin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vedeshkin on 03.09.2018.
 */
public class SendMessageListenerImpl implements ActionListener {

    private JTextArea chatBox;
    private JTextField messageField;

    public SendMessageListenerImpl(JTextArea chatBox, JTextField messageField) {
        this.chatBox = chatBox;
        this.messageField = messageField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (messageField.getText().length() > 1)
        chatBox.append( messageField.getText()+ "\n");
        messageField.setText("");
    }
}
