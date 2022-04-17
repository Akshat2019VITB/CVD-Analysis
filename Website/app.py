import flask
import numpy as np
from flask import Flask, render_template,request, url_for
import pickle
import pandas as pd
#Initialize the flask App


app = Flask(__name__)
model = pickle.load(open('D:\dev files\github repos\CVD-Analysis\Website\model.pkl', 'rb'))
@app.route('/')
def home():
    return render_template('index.html')

@app.route('/',methods=['POST'])



def predict():
    if flask.request.method == "POST":
        input_features = [float(x) for x in request.form.values()]
        features_value = [np.array(input_features)]
        features_name = ['age_in_years','gender','height','weight','BMI','ap_hi','ap_lo','MAP','cholestrol','Heart_Rate',
     'Max_Heart_Rate','glu','smoke','alco','active']
        df = pd.DataFrame(features_value, columns=features_name)
    
        output = model.predict(df)
    
        return render_template('index.html', prediction_text=output)  



#@app.route('/predict',methods=['POST', 'GET'])


#if Flask.request.method == "POST":

    #def predict():
    
        #input_features = [float(x) for x in request.form.values()]
        #features_value = [np.array(input_features)]
        #features_name = ['age_in_years','gender','height','weight','BMI','ap_hi','ap_lo','MAP','cholestrol','Heart_Rate',
     #'Max_Heart_Rate','glu','smoke','alco','active']
        #df = pd.DataFrame(features_value, columns=features_name)
    
        #output = model.predict(df)
    
        #return render_template('result.html', prediction_text=output)  
  
  
  
  
  
  #  return render_template('result.html', prediction_text=output)
    


    
    
 #   prediction=model.predict(features_value)
  #  output = prediction[0], 2
 #   return render_template('index.html', prediction_text=output)
   # return render_template('index.html', prediction_text='${}'.format(output))


if __name__ == '__main__':
    app.run(debug=True)