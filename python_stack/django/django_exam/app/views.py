from django.shortcuts import render, redirect, get_object_or_404
from .models import User, Project
from django.contrib import messages
from django.contrib.auth.hashers import make_password, check_password

# Home Page: Login & Register form
def index(request):
    return render(request, 'index.html')

# Register a new user
def register(request):
    if request.method == "POST":
        first_name = request.POST['first_name']
        last_name = request.POST['last_name']
        email = request.POST['email']
        password = request.POST['password']
        confirm_password = request.POST['confirm_password']
        
        # Basic validations
        if password != confirm_password:
            messages.error(request, "Passwords do not match")
            return redirect('/')
        
        if User.objects.filter(email=email).exists():
            messages.error(request, "Email already registered")
            return redirect('/')
        
        # Save user
        hashed_pw = make_password(password)
        user = User.objects.create(
            first_name=first_name,
            last_name=last_name,
            email=email,
            password=hashed_pw
        )
        
        request.session['user_id'] = user.id
        return redirect('dashboard')
    return redirect('/')

# Login user
def login(request):
    if request.method == "POST":
        email = request.POST['email']
        password = request.POST['password']
        
        user = User.objects.filter(email=email).first()
        if user and check_password(password, user.password):
            request.session['user_id'] = user.id
            return redirect('dashboard')
        else:
            messages.error(request, "Invalid email or password")
            return redirect('/')
    return redirect('/')

# Logout
def logout(request):
    request.session.clear()  
    return redirect('/')

# Dashboard
def dashboard(request):
    if 'user_id' not in request.session:
        return redirect('/')
    
    user = User.objects.get(id=request.session['user_id'])
    projects = Project.objects.all()
    context = {
        'user': user,
        'projects': projects
    }
    return render(request, 'dashboard.html', context)

# Create a Project
def create_project(request):
    if request.method == "POST":
        name = request.POST['name']
        description = request.POST['description']
        start_date = request.POST['start_date']
        end_date = request.POST['end_date']
        
        user = User.objects.get(id=request.session['user_id'])
        Project.objects.create(
            name=name,
            description=description,
            start_date=start_date,
            end_date=end_date,
            creator=user
        )
        return redirect('dashboard')
    
    return render(request, 'create_project.html')

# View Project Detail
def view_project(request, project_id):
    project = get_object_or_404(Project, id=project_id)
    context = {
        'project': project
    }
    return render(request, 'project_detail.html', context)

# Edit a Project
def edit_project(request, project_id):
    project = get_object_or_404(Project, id=project_id)

    if request.method == 'POST':
        project.name = request.POST['name']
        project.description = request.POST['description']
        project.start_date = request.POST['start_date']
        project.end_date = request.POST['end_date']
        project.save()

        return redirect('view_project', project_id=project.id)

    return render(request, 'edit_project.html', {'project': project})

def delete_project(request, project_id):
    project = get_object_or_404(Project, id=project_id)

    project.delete()
    return redirect('dashboard')


def join_project(request, project_id):
    project = get_object_or_404(Project, id=project_id)

    if not project.members.filter(id=request.user.id).exists():  # Use filter and exists() for checking membership
        project.members.add(request.user)  # Add the user to the project
        messages.success(request, f"You have successfully joined the project: {project.name}")
    else:
        messages.info(request, f"You are already a member of the project: {project.name}")
    
    return redirect('view_project', project_id=project.id)
