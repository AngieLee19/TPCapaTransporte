import java.io.* ;

import java.net.* ;

class Servidor {

    static final int puerto =5000;

    public Servidor( ) {

        try {
            System.out.println();
            System.out.println("Creando socket");
            System.out.println();

            ServerSocket skServidor = new ServerSocket(puerto);

            System.out.println("Escucho desde el puerto " + puerto);
            System.out.println();

            for ( int numeroCliente = 0; numeroCliente < 3; numeroCliente++) {

                System.out.println("______________________________________________________________________");
                System.out.println();

                Socket skCliente = skServidor.accept(); // Crea objeto
                System.out.println("Crea objeto para el cliente: " +numeroCliente);
                System.out.println();

                System.out.println("Acepto al cliente: " + numeroCliente);
                System.out.println();

                OutputStream aux = skCliente.getOutputStream();

                DataOutputStream flujo= new DataOutputStream( aux );

                flujo.writeUTF( "Conexión establecida con el servidor desde el puerto " + puerto +"."+" Soy el cliente "+numeroCliente);

                skCliente.close();
                System.out.println("Finaliza concexión con el cliente "+numeroCliente);

            }
            System.out.println("______________________________________________________________________");
            System.out.println();
            System.out.println("CUIDADO!");
            System.out.println("Ya no se puede establecer más conexiones");

        } catch( Exception e ) {

            System.out.println( e.getMessage() );

        }

    }

    public static void main( String[] arg ) {

        new Servidor();

    }

}