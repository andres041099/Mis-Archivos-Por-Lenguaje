#include <iostream>
#include "esconu.h"
#include <vector>

using namespace std;

int main ()
{
    vector <string> nombres;
    vector<string>:: iterator iterador; 
    int opcion ;
    string nombreTemporal;
    
    nombres.push_back("Carbezo");
    nombres.push_back("Anacleta");
    nombres.push_back("UYScuti");
    nombres.push_back("Atom");

    do
    {

        do
        {
            BorraPantalla();
            cout << "Este programa es una para provar los vectores" << endl << endl ;
            cout << "seleccione la opcion numerica que haga referencia a la accion que desea realizar" << endl << endl;
            cout << "1- Listarlo en pantalla en orden normal e inverso para " << endl;
            cout << "2- Mostrar el primer y último elemento del vector." << endl;
            cout << "3- Insertar nombres en el vector." << endl;
            cout << "4- Despliegue el tamaño actual del vector." << endl;
            cout << "5- Listar el contenido del vector ordenado en pantalla." << endl;
            cout << "6- Salir del Programa"<< endl;

            cout << "Dijite el numero de la opcion que desea utilizar :";
            cin >> opcion;
        }while (opcion <=0 || opcion > 7);

    

        switch (opcion)
        {
        case 1 :
            BorraPantalla();
            iterador = nombres.begin();    
            while (iterador != nombres.end() )
            {
                cout << *iterador << endl;   
                iterador++;               
            }
            cout << endl;
            TeclaPresionada("Ahora listado a inverso");
        
            BorraPantalla();
            
            iterador = nombres.end();    
            --iterador;
            while (iterador != nombres.begin()  )
            {
                cout << *iterador << endl;   
                iterador--;               
            }
            cout << *iterador << endl;
            cout << endl;
            TeclaPresionada("continuar");
            break;
        case 2 :
            BorraPantalla();
            cout << nombres.front() << endl;
            cout << nombres.back() << endl;
            TeclaPresionada("Precione una tecla para continuar");
            break;
        case 3 :
            BorraPantalla();
            cout << "Ingrese el Nombre que quiere Agregar: ";
            cin >> nombreTemporal;
            nombres.push_back(nombreTemporal);
            TeclaPresionada("Listo, Precione una tecla para continuar");
            break;
        case 4 :
            BorraPantalla();
            cout <<"la tamaño del vector es: "<< nombres.size() << endl;
            TeclaPresionada("Precione una tecla para continuar");
            break;
        case 5 :
            BorraPantalla();
            iterador = nombres.begin();    
            while (iterador != nombres.end() )
            {
                cout << *iterador << endl;   
                iterador++;               
            }
            TeclaPresionada("Precione una tecla para continuar");
            break;
        default:
            break;
    }
    }while (opcion != 6 );
    
    return 0;
}