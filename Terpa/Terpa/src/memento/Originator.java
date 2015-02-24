package memento;


public class Originator 
{
    private String state;
    
 
    public void set(String state) 
    { 
 
       this.state = state; 
    }
 
    public Memento saveToMemento() 
    { 
       
        return new Memento(state); 
    }
 
    public void restoreFromMemento(Memento m) 
    {
        state = m.getSavedState(); 
       
    }
}   