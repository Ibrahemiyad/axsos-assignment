from flask import Flask, render_template, session, redirect, url_for

app = Flask(__name__)
app.secret_key = "supersecretkey" 

@app.route('/')
def index():
    if 'counter' not in session:
        session['counter'] = 0

    session['counter'] += 1 
    return render_template('show.html', visits=session['counter'])

@app.route('/destroy_session')
def destroy_session():
    session.clear() 
    return redirect(url_for('index'))

if __name__ == "__main__":
    app.run(debug=True)

