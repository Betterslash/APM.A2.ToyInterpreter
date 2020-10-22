package View;

import Controller.Controller;
import Model.ProgramState;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.Value;
import Model.adt.*;
import Model.except.MyException;
import Model.exp.ArithmExp;
import Model.exp.Expression;
import Model.exp.VarExp;
import Model.stmt.*;
import Repository.Repository;
import Model.exp.ValueExp;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) throws MyException {
        Repository repository = new Repository();
        Controller controller = new Controller(repository);
        IStmt ex1= new CompStmt(new DeclStmt("v",new IntType()),
                new CompStmt(new AssignStmt("v",
                        new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));
        IStmt ex2 = new CompStmt( new DeclStmt("a",new IntType()),
                new CompStmt(new DeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithmExp('+',new ValueExp(new IntValue(2)),
                                new ArithmExp('/',new ValueExp(new IntValue(10)), new ValueExp(new IntValue(5))))),  new CompStmt(new AssignStmt("b",new ArithmExp('+',new VarExp("a"),
                                new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        IStmt ex3 = new CompStmt(new DeclStmt("a",new BoolType()),
                new CompStmt(new DeclStmt("v", new IntType()),new CompStmt(new AssignStmt("a",
                        new ValueExp(new BoolValue(false))),
                        new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))),
                                new AssignStmt("v", new ValueExp(new IntValue(3)))),
                                new PrintStmt(new VarExp("v"))))));

        while (true) {
            try {
                ProgramState programState = null;
                IDict<String, Value> symTable = new MyDict<String, Value>();
                IStack<IStmt> exeStack = new MyStack<IStmt>();
                IList<Value> output = new MyList<Value>();
                System.out.println("------------------------");
                System.out.println("1-> " + ex1);
                System.out.println("2-> " + ex2);
                System.out.println("3-> " + ex3);
                System.out.println("------------------------");
                System.out.println("Give your choice here >>");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                switch (choice) {
                    case "1": {
                        exeStack.push(ex1);
                        programState = new ProgramState(symTable, exeStack, output, ex1);
                        controller.add(programState);
                        controller.allStep();
                        System.out.println(programState.getOut().getOut());
                        break;
                    }
                    case "2": {
                        exeStack.push(ex2);
                        programState = new ProgramState(symTable, exeStack, output, ex2);
                        controller.add(programState);
                        controller.allStep();
                        System.out.println(programState.getOut().getOut());
                        break;
                    }
                    case "3": {
                        exeStack.push(ex3);
                        programState = new ProgramState(symTable, exeStack, output, ex3);
                        controller.add(programState);
                        controller.allStep();
                        System.out.println(programState.getOut().getOut());
                        break;
                    }
                    case "X":
                        return;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            }
    }
}
