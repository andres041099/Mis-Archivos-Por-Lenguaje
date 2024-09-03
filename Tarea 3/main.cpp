#include <iostream>
#include "esconu.h"
#include <vector>
#include <algorithm>
using namespace std;

int main ()
{
    string sandwich;
    string acompanante; 
    vector <pair <string, string > > combo;
    vector < pair <string, string> > :: iterator iter;
    string cadena;
    int eleccion;
    int opcion, j, k= 0 ;
    BorraPantalla();
    
    
    combo.push_back (make_pair("grande", "sapote"));
    combo.push_back (make_pair("peque;o", "naranja"));

    do
    {   do 
        {
            BorraPantalla();
            cout << "Don Churumusco, cafetería con ofertas de sándwiches con batidas o jugos." << endl;
            cout << "MENU"<<endl;
            cout << "1) Agregar combo"<<endl;
            cout << "2) Listar combos"<<endl;
            cout << "3) Eliminar combos"<<endl;
            cout << "4) Buscar combo."<<endl;
            cout << "5 Salir "<< endl; 
            cout << "Dijite el numero corespondiente a la funcion que quiere realizar: ";
            cin >> opcion;

            switch (opcion)
            {
            case 1:
                cout << "Indique que tipo de sandwich desea (pequeno, mediano o grande): " ; 
                cin >> sandwich;
                cout << endl;
                cout << "Indique el saber de la bebida con la que va a companar(el sabor del jugo o el sabor de la batida) " ;
                cin >> acompanante;
                cout << endl;
                //combo.push_back( make_pair(sandwich, acompanante));
                combo.push_back (make_pair(sandwich,acompanante));   

                break;
            case 2:

                cout << "Lista de Combos Guardados" << endl << endl;
                iter = combo.begin();
                while( iter != combo.end() )
                {
                    cout << k << " = "<< (*iter).first << "   " << (*iter).second << endl;
                    
                    iter++;
                    k++;
                }
                TeclaPresionada("Precione tecla para continuar");
                break;
            case 3:
                iter = combo.begin();
                while( iter != combo.end() )
                {
                    cout << k << " = "<< (*iter).first << "   " << (*iter).second << endl;
                    
                    iter++;
                    k++;
                }
                cout << "Dijite en numero del vector que desea eliminar: "; 
                cin >> j;
                cout << endl;
                if (j == 0)
                {
                combo.erase (combo.begin());
                }
                else 
                    if (j > 0)
                    {
                        combo.erase (combo.begin() + j);
                    }
                break;
            case 4:
                cout << "Dijite el Tamano del sandwich o el sabor de la bebida : ";
                cin >>cadena; 
                cout << endl <<endl;
                TeclaPresionada("Estos son los Resultados de la busqueda"); 
                iter = combo.begin();
                while( iter != combo.end() )
                {
                    if (cadena == iter->first || cadena == iter->second )
                    {
                        cout << iter->first << " " << iter->second << endl;
                        iter++;
                    }
                    else
                        iter++;

                }
                TeclaPresionada("precione una tecla pra continuar");
                      
               
                break;
            case 5:
            opcion =5;
            break;
            default:
                opcion =6 ;
                break;
            }
             
        }while (opcion < 0 || opcion >6 );

    }while (opcion != 5);

    return 0;
}