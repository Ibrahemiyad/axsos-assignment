from flask import Flask, render_template, request
from datetime import datetime

app = Flask(__name__)

# تعريف الفواكه مع الكميات الافتراضية
fruits = {
    "Strawberry": 0,
    "Raspberry": 1,
    "Apple": 4
}

@app.route('/')
def index():
    return render_template('index.html', quantities=fruits)

@app.route('/checkout', methods=['POST'])
def checkout():
    quantities = {fruit: int(request.form.get(f"quantities[{fruit}]")) for fruit in fruits}
    name = request.form['name']
    student_id = request.form['student_id']
    total_items = sum(quantities.values())
    time = datetime.now().strftime("%B %d, %Y %I:%M:%S %p")
    
    return render_template('checkout.html', quantities=quantities, name=name, student_id=student_id, total_items=total_items, time=time)

if __name__ == '__main__':
    app.run(debug=True)
