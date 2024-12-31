import socket
import threading
import tkinter as tk
from tkinter import scrolledtext
import struct


SERVER_IP = '127.0.0.1'
TCP_PORT = 1501
UDP_GROUP = '233.0.0.1'
UDP_PORT = 1502
BUFFER_SIZE = 1024

#  UDP
def receive_udp_messages():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    sock.bind(('', UDP_PORT))

    group = socket.inet_aton(UDP_GROUP)
    mreq = struct.pack('4sL', group, socket.INADDR_ANY)
    sock.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)

    while True:
        message, _ = sock.recvfrom(BUFFER_SIZE)
        if message:
            display_message(message.decode('utf-8'))

#  TCP

def send_message():
    message = message_entry.get()
    if message:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as tcp_socket:
            tcp_socket.connect((SERVER_IP, TCP_PORT))
            tcp_socket.send(message.encode('utf-8'))
        message_entry.delete(0, tk.END)

def display_message(message):
    message_display.config(state=tk.NORMAL)
    message_display.insert(tk.END, message + '\n')
    message_display.config(state=tk.DISABLED)

def create_gui():
    global message_entry, message_display

    window = tk.Tk()
    window.title('Чат')

    message_display = scrolledtext.ScrolledText(window, wrap=tk.WORD, width=50, height=20, state=tk.DISABLED)
    message_display.pack(padx=10, pady=10)


    message_entry = tk.Entry(window, width=50)
    message_entry.pack(padx=10, pady=10)
    message_entry.bind('<Return>', lambda event: send_message()) 


    receive_thread = threading.Thread(target=receive_udp_messages)
    receive_thread.daemon = True
    receive_thread.start()

    window.mainloop()

if __name__ == "__main__":
    create_gui()
