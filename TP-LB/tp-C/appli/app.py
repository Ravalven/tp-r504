from flask import request, Flask
import json, os

app = Flask(__name__)

@app.route('/')
def hello_world():
    id_container = os.environ.get('HOSTNAME')
    return id_container

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')