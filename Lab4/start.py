import subprocess
import time
import os

server_path = os.path.join('C:\\Users\\Kerim\\Desktop\\RSP\\Lab4', 'server.py')
client_path = os.path.join('C:\\Users\\Kerim\\Desktop\\RSP\\Lab4', 'client.py')

# Запуск сервера
server_process = subprocess.Popen(['python', server_path])
print("Сервер запущен...")

time.sleep(2)
for i in range(2):
	client_process = subprocess.Popen(['python', client_path])
	print(f"Клиент запущен {i + 1} раз...")

server_process.wait()
