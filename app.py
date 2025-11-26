import sys

def main():
    tasks = []
    print("--- To-Do List App (Roll 533) ---")
    # Simple logic for demonstration
    tasks.append("Complete Jenkins Lab")
    tasks.append("Submit Screenshots")
    
    if len(tasks) > 0:
        print(f"Current tasks: {tasks}")
    else:
        print("No tasks found.")

if __name__ == "__main__":
    main()