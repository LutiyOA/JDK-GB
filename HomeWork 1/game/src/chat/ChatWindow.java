package chat;

/*
Задача 5: Создать окно клиента чата. Окно должно содержать JtextField
        для ввода логина, пароля, IP-адреса сервера, порта подключения
        к серверу, область ввода сообщений, JTextArea область просмотра
        сообщений чата и JButton подключения к серверу и отправки сообщения
        в чат. Желательно сразу сгруппировать компоненты, относящиеся
        к серверу сгруппировать на JPanel сверху экрана, а компоненты,
        относящиеся к отправке сообщения – на JPanel снизу

        Домашнее задание
Семинар 1. Простейшие интерфейсы пользователя
Задачи:
1. Выполнить все задания семинара, если они не были решены,
без ограничений по времени;
2. Отправлять сообщения из текстового поля сообщения в лог
по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
3. Продублировать импровизированный лог (историю) чата в файле;
4. При запуске клиента чата заполнять поле истории из файла, если он существует.
Обратите внимание, что чаще всего история сообщений хранится на сервере
и заполнение истории чата лучше делать при соединении с сервером, а не при
открытии окна клиента.

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_POSX = 200;
    private static final int WINDOW_POSY = 100;


    ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(false);

        // Создаем верхнюю панель и добавляем в неё нужные компоненты
        JPanel panServer = new JPanel(new GridLayout(5, 2));

        panServer.add(new JLabel("Логин:"));
        JTextField login = new JTextField();
        panServer.add(login);

        panServer.add(new JLabel("Пароль:"));
        JPasswordField password = new JPasswordField();
        password.setEchoChar('*');
        panServer.add(password);

        panServer.add(new JLabel("IP сервера:"));
        JTextField serverIP = new JTextField();
        panServer.add(serverIP);

        panServer.add(new JLabel("Порт сервера:"));
        JTextField portServer = new JTextField();
        panServer.add(portServer);

        JButton connectBtn = new JButton("Подключиться");
        panServer.add(connectBtn);
        // Обработчик кнопки подключения к серверу
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(panServer, BorderLayout.NORTH);

        // Создаем нижнюю панель и добавляем в неё нужные компоненты
        JPanel panChat = new JPanel(new GridLayout(1, 2));
        JTextArea chat = new JTextArea();
        chat.setEditable(false);

        // добавляем список подключенных пользователей
        JList listUsers = new JList();
        String arrayUsers[] = {"John", "Paul", "Julia", "Ringo"};
        listUsers.setListData(arrayUsers);
        panChat.add(chat);
        panChat.add(listUsers);

        add(panChat);

        JPanel panSendMessage = new JPanel(new GridLayout(4, 1));

        JTextField sendMessage = new JTextField();
        panSendMessage.add(sendMessage);

        JButton sendBtn = new JButton("Отправить");
        panSendMessage.add(sendBtn);

        // Обработчик кнопки отправки сообщения в чат
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chat.append(login.getText() + ": " + sendMessage.getText() + "\n");
                sendMessage.setText("");
                sendMessage.requestFocus();

            }
        });

        add(panSendMessage, BorderLayout.SOUTH);

        setVisible(true);
    }
}
