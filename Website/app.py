import requests
from flask import Flask,request,render_template
import numpy as np
import pickle
import json
app = Flask(__name__)


@app.route('/')
def home():
    return render_template("index.html")

@app.route('/predict',methods=["POST"])
def predict():
    input_features = [float(x) for x in request.form.values()]
    input = [input_features[3],input_features[4],input_features[0],input_features[1],input_features[2]]
    print(input_features)
    features_value = [np.array(input)]
    
    features_name = ['age_in_years', 'gender', 'weight','BMI','ap_hi','ap_lo','cholestrol','Max_Heart_Rate', 'gluc', 'smoke','alco','active']
    #payload_scoring = {"input_data": [{"field": [['Global_reactive_power','Global_intensity','Sub_metering_1','Sub_metering_2','Sub_metering_3']], "values": [input]}]}

    #response_scoring = requests.post('https://us-south.ml.cloud.ibm.com/ml/v4/deployments/a4517dcd-1391-437b-a5c5-831dc5ee2d28/predictions?version=2021-08-01', json=payload_scoring, headers={'Authorization': 'Bearer ' + mltoken})
    #print("Scoring response")
    #predictions=response_scoring.json()
    #pred=predictions['predictions'][0]['values'][0][0]
    #print(pred)
    if():
        return render_template('index.html', prediction_text='you are suffering from: {}'.format(pred))

if __name__=="__main__":
    app.run(debug=False)