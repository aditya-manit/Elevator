package com.aditya.task;

public class TaskApplication {
    public static void main(String[] args) {
        Task task1= Task.createTask("Get Rich",5);
        Task task2= Task.createTask("Get Rich",5);
        System.out.println(task1.equals(task2));
        System.out.println(task2.equals(task1));
        System.out.println(task1.equals(task1));
        System.out.println(task1==task2);



  /*      Task task2= Task.taskWithDefaultPriority("Get a job");
        task1.done();
        Task task =new Task.Builder()
                .withTitle("using builder class")
                .withDate(new Date())
                .build();
        System.out.println(task);
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task1.getPriority());
        System.out.println(task1.moreImportant(task2));*/
    }
}
