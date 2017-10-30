package com.theja.book.chap17.java;

import com.theja.book.chap14.java.BeatBoxSaveOnly;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.Remote;

public class ServerBrowser {
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public ServerBrowser() {
    }

    public void buildGUI() {
        JFrame frame = new JFrame("RMI Browser");
        this.mainPanel = new JPanel();
        frame.getContentPane().add("Center", this.mainPanel);
        Object[] services = this.getServicesList();
        this.serviceList = new JComboBox(services);
        frame.getContentPane().add("North", this.serviceList);
        this.serviceList.addActionListener(new MyListListener());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    void loadService(Object serviceSelection) {
        try {
            Service svc = this.server.getService(serviceSelection);
            this.mainPanel.removeAll();
            this.mainPanel.add(svc.getGuiPanel());
            this.mainPanel.validate();
            this.mainPanel.repaint();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    Object[] getServicesList() {
        Object obj = null;
        Object[] services = (Object[])null;

        try {
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        this.server = (ServiceServer) obj;

        try {
            services = this.server.getServiceList();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return services;
    }

    public static void main(String[] args) {
        (new ServiceBrowser()).buildGUI();
    }

    private static class ServiceBrowser extends BeatBoxSaveOnly {
        public void buildGUI() {
        }

        public Service getService(Object serviceSelection) {
            return null;
        }
    }

    class MyListListener implements ActionListener {
        MyListListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            Object selection = ServerBrowser.this.serviceList.getSelectedItem();
            ServerBrowser.this.loadService(selection);
        }
    }


}
