import requests
import csv
import datetime

token = "d92734a60c35bd3d2632c97fdf14c4168be65d58"
city = "mumbai"

url = f"https://api.waqi.info/feed/{city}/?token={token}"
data = requests.get(url).json()

# Check status
if data["status"] != "ok":
    print("Error:", data)
    exit()

# Extract values safely
aqi = data["data"].get("aqi", None)
iaqi = data["data"].get("iaqi", {})

pm25 = iaqi.get("pm25", {}).get("v", None)
pm10 = iaqi.get("pm10", {}).get("v", None)
temp = iaqi.get("temp", {}).get("v", None)
humidity = iaqi.get("h", {}).get("v", None)

# Current timestamp
timestamp = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")

# CSV file name
filename = "./practice/aqi_data.csv"

# If file does not exist, create header
try:
    with open(filename, "x", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["timestamp", "aqi", "pm25", "pm10", "temperature", "humidity"])
except FileExistsError:
    pass

# Append data row
with open(filename, "a", newline="") as f:
    writer = csv.writer(f)
    writer.writerow([timestamp, aqi, pm25, pm10, temp, humidity])

print("Saved to CSV:", filename)
