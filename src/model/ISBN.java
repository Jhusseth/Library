package model;

public class ISBN<V,E> implements InISBN<V,E> {
	
    private NodeISBN<E> start;
    
    private int tam;
   
    public ISBN(){
        start = null;
        tam = 0;
    }
    
    @Override
    public boolean isEmpty(){
        return start == null;
    }
    
    public int getTamanio(){
        return tam;
    }
    
    @Override
    public void add(E element){
        
    	NodeISBN<E> nuevo = new NodeISBN<E>();
       
        nuevo.setValor(element);
        
        if (isEmpty()) {
           
            start = nuevo;
        
        } else{
           
            nuevo.setSiguiente(start);
            
            start = nuevo;
        }
        
        tam++;
    }
    
    @Override
    public void insertPerReference(V referencia, E valor){
        
    	NodeISBN<E> nuevo = new NodeISBN<E>();
       
        nuevo.setValor(valor);
        
        if (!isEmpty()) {
            
            if (search(referencia)) {
                
            	NodeISBN<E> aux = start;
                
                while (aux.getValue() != referencia) {
                    aux = aux.getSiguiente();
                }
               
                NodeISBN<E> siguiente = aux.getSiguiente();
               
                aux.setSiguiente(nuevo);
                
                nuevo.setSiguiente(siguiente);
                
                
                tam++;
            }
        }
    }
    
    @Override
    public void insertPerPosicion(int posicion, E valor){
        
        if(posicion>=0 && posicion<=tam){
        	NodeISBN<E> nuevo = new NodeISBN<E>();
            
            if(posicion == 0){
               
                nuevo.setSiguiente(start);
                start = nuevo;
            }
            else{
                
                if(posicion == tam){
                	NodeISBN<E> aux = start;
                    
                    while(aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }
                    
                    aux.setSiguiente(nuevo);              
                }
                else{
                    
                	NodeISBN<E> aux = start;
                    
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getSiguiente();
                    }
                    
                    NodeISBN<E> siguiente = aux.getSiguiente();
                   
                    aux.setSiguiente(nuevo);
                   
                    nuevo.setSiguiente(siguiente);
                }
            }
            
            tam++;
        }
    }
    
    @Override
    public E getValue(int posicion) throws Exception{
        
        if(posicion>=0 && posicion<tam){
           
            if (posicion == 0) {
                
                return start.getValue();
            }else{
               
            	NodeISBN<E> aux = start;
               
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                
                return aux.getValue();
            }
        
        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }
    
    
    @Override
    public boolean search(V referencia){
        
    	NodeISBN<E> aux = start;
        
        boolean encontrado = false;
        
        while(aux != null && encontrado != true){
            
            if (referencia == aux.getValue()){
                
                encontrado = true;
            }
            else{
                
                aux = aux.getSiguiente();
            }
        }
        
        return encontrado;
    }
    
    @Override
    public void remove(V referencia){
        
        if (search(referencia)) {
            
            if (start.getValue() == referencia) {
               
                start = start.getSiguiente();
            } else{
               
            	NodeISBN<E> aux = start;
                
                while(aux.getSiguiente().getValue() != referencia){
                    aux = aux.getSiguiente();
                }
                
                NodeISBN<E> siguiente = aux.getSiguiente().getSiguiente();
                
                aux.setSiguiente(siguiente);  
            }
           
            tam--;
        }
    }
}
