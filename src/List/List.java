package List;
import Node.iNode;

public class List<T> implements IList<iNode<T>> {
	
    private iNode<T> first;
    
    private int tam;
    
    private int code;
   
    public List(){
        first = null;
        tam = 0;
    }
    
    @Override
    public boolean isEmpty(){
        return first == null;
    }
    
    public int getSize(){
        return tam;
    }
    
    @Override
    public void add(iNode<T> element){
    	
    	iNode<T> nuevo = element;
        
        if (isEmpty()) {
           
            first = nuevo;
        
        } else{
           
            nuevo.setNext(first);
            
            first = nuevo;
        }
        
        tam++;
    }
    
    
    @Override
    public boolean search(iNode<T> referencia){
        
    	iNode<T> aux = first;
        
        boolean encontrado = false;
        
        while(aux != null && encontrado != true){
            
            if (referencia == aux.getData()){
                
                encontrado = true;
            }
            else{
                
                aux = aux.getNext();
            }
        }
        
        return encontrado;
    }
    
    @Override
    public void remove(iNode<T> referencia){
        
        if (search(referencia)) {
            
            if (first.getData() == referencia) {
               
                first = first.getNext();
            } else{
               
            	iNode<T> aux = first;
                
                while(aux.getNext().getData() != referencia){
                    aux = aux.getNext();
                }
                
                iNode<T> siguiente = aux.getNext().getNext();
                
                aux.setNext(siguiente);  
            }
           
            tam--;
        }
    }

	@Override
	public iNode<T> getFirst() {
		
		return first;
	}
}
