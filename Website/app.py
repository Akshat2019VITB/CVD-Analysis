import numpy as np
from flask import Flask, render_template,request, url_for
import pickle
#Initialize the flask App


app = Flask(__name__)
model = pickle.load(open('D:\dev files\github repos\CVD-Analysis\Website\model.pkl', 'rb'))
@app.route('/')
def home():
    return render_template('index.html')

@app.route('/',methods=['POST','GET'])
def my_home():
    return render_template('index.html')

@app.route('/predict',methods=['POST'])
def predict():
    
    input_features = [float(x) for x in request.form.values()]
    features_value = [np.array(input_features)]
    
    features_name = ['age_in_years','gender','height','weight','BMI','ap_hi','ap_lo','MAP','cholestrol','Heart_Rate','Max_Heart_Rate','glu','smoke','alco','active']
    
 
    prediction=model.predict(features_value)
    output = round(prediction[0], 2)
    return render_template('index.html', prediction_text=output)

if __name__ == '__main__':
    app.run(debug=True)