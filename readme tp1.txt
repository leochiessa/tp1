-como minimo uno.
-los bloques deben ser synchronized porque todos usan el mismo recurso compartido.
-el recurso compartido es la clase Cervecería la cual consta de 2 metodos. Set: que es utilizado por la
 clase Productor para acumular cerveza. Y el metodo Get: que es utilizado por la clase Consumidor para decrementar
 la cerveza.
-una forma es hacer que las clases hereden de Thread y sobreescriban el metodo run para que lo que hagan se
 ejecute de forma secuencial en un hilo. Y la otra es implementar la interface Runnable para que los procesos
 se ejecuten en un hilo diferente.