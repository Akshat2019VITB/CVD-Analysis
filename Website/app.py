import numpy as np
import pandas as pd
from flask import Flask, request, render_template
import joblib


app = Flask(__name__)
#model = joblib.load(open('CKD.save', 'rb'))
@app.route('/')
def home():
    return render_template('index.html')
#@app.route('/Prediction',methods=['POST','GET'])
#def prediction():
#    return render_template('check.html')
#@app.route('/Home',methods=['POST','GET'])
#def my_home():
#    return render_template('index.html')

#@app.route('/predict',methods=['POST'])
#def predict():
    
#    input_features = [float(x) for x in request.form.values()]
#    features_value = [np.array(input_features)]
    
#    features_name = ['blood_urea', 'blood glucose random', 'anemia',
#       'coronary_artery_disease', 'pus_cell', 'red_blood_cells',
#       'diabetesmellitus', 'pedal_edema']
    
#    df = pd.DataFrame(features_value, columns=features_name)
    
#    output = model.predict(df)
    
#    return render_template('result.html', prediction_text=output)

if __name__=="__main__":
    app.run(debug=True)
