package multicatch;

public class MultiCatch {
    public void foo() {
        try {
        // ...
        } catch(IllegalArgumentException e2) {    
        // ...
        } catch(RuntimeException e1) {
        // ...
        }
    }
    
    public void bar() {
        try {
        // ...
        } catch(IllegalStateException | IllegalArgumentException e) {
        // ...
        }
    }
    
    public void baz() {
        try {
        // ...
        } catch(IllegalArgumentException | IllegalStateException e) {
        // ...
        }
    }
    
    public void qux() {
        try {
        // ...
        } catch(RuntimeException e2) {    
        // ...
        } catch(Exception e1) {
        // ...
        }
    }
}
