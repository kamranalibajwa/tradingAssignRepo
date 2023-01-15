
# Urls Localhost

Swagger Urls:
http://localhost:8000/swagger-ui/index.html

Api Urls:
http://localhost:8000/get-cutoff-time?currency1=AED&currency2=AUD&tradeDate=16-01-2023

Database Schema:
src->main->resources->
data.sql & 
schema.sql

# Live Demo1 (Google Cloud KBE -> based on docker image):

Swagger documentation:

http://34.134.109.119:8000/swagger-ui/index.html#/currency-trading-controller/retrieveCutoffTime

Test Case:
http://34.134.109.119:8000/get-cutoff-time?currency1=USD&currency2=DKK&tradeDate=16-01-2023

# Live Demo2 (mogenius -> based on docker image):

Swagger documentation:
https://tradeimage3ser-prod-trading-bbgu00.mo4.mogenius.io/swagger-ui/index.html

Test Case:
https://tradeimage3ser-prod-trading-bbgu00.mo4.mogenius.io/get-cutoff-time?currency1=USD&currency2=DKK&tradeDate=16-01-2023