import requests
from bs4 import BeautifulSoup
import csv

url="https://quotes.toscrape.com/"
page=requests.get(url)
soup=BeautifulSoup(page.text,"html.parser")
quotes=soup.find_all("div",class_="quote")

file=open("quotes.csv","w",newline="",encoding="utf-8")
writer=csv.writer(file)
writer.writerow(["Quote","Author"])

for q in quotes:
    text=q.find("span",class_="text").text
    author=q.find("small",class_="author").text
    writer.writerow([text,author])

file .close()
