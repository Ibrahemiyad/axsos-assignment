from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def checkerboard_default():
    return render_template('checkerboard.html', rows=8, cols=8, color1='black', color2='white')

@app.route('/<int:rows>')
def checkerboard_rows(rows):
    return render_template('checkerboard.html', rows=rows, cols=8, color1='black', color2='white')

@app.route('/<int:rows>/<int:cols>')
def checkerboard_custom(rows, cols):
    return render_template('checkerboard.html', rows=rows, cols=cols, color1='black', color2='white')

@app.route('/<int:rows>/<int:cols>/<color1>/<color2>')
def checkerboard_custom_colors(rows, cols, color1, color2):
    return render_template('checkerboard.html', rows=rows, cols=cols, color1=color1, color2=color2)

if __name__ == "__main__":
    app.run(debug=True)
