//
//  main.cpp
//  Vector 2
//
//  Created by Andrés Enrique Linares Félix on 24/09/12.
//  Copyright (c) 2012 Andrés Enrique Linares Félix. All rights reserved.
//

#include <vector>
#include <iostream>
#include <esconu.h>


using namespace std;
int main ()
{
    BorraPantalla();
    
    vector <int> v1;

    // Instanciación de un vector con 10 elementos (puede seguir creciendo después del décimo elemento)
    vector <int> v10Elementos (10);

    // Instanciación de un vector con 10 elementos cada uno inicializado en 35
    vector <int> v10ElementosI (10, 35);

    // Instanciación de un vector con el contenido de otro.
    vector <int> vCopia (v10ElementosI);

    v10ElementosI[3] = 18;
    
    // Instanciación de un vector con parte del contenido de otro.
    vector <int> vAlgunosElementosCopiados( v10ElementosI.begin (), v10ElementosI.begin () + 5 );
    
    
    cout << "Tamaño del vector v1: " << v1.size() << endl;
    cout << "Tamaño del vector v10Elementos(): " << v10Elementos.size() << endl;
    cout << "Tamaño del vector v10ElementosI(): " << v10ElementosI.size() << endl;
    cout << "Tamaño del vector vCopia(): " << vCopia.size() << endl;
    cout << "Tamaño del vector vAlgunosElementosCopiados(): " << vAlgunosElementosCopiados.size() << endl;
    
    cout << endl << "Vector de 10 elementos iguales" << endl;
    for (int i = 0; i <= v10ElementosI.size() - 1; i++)
        cout << v10ElementosI.at(i) << " ";
    cout << endl;
    
    cout << endl << "Vector Copia del anterior" << endl;
    for (int i = 0; i <= vCopia.size() - 1; i++)
        cout << vCopia.at(i) << " ";
    cout << endl;

    cout << endl << "Vector Copia de algunos elementos del anterior" << endl;
    for (int i = 0; i <= vAlgunosElementosCopiados.size() - 1; i++)
        cout << vAlgunosElementosCopiados.at(i) << " ";
    cout << endl;
    

return 0;
    
}
