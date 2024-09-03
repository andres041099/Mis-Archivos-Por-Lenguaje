#include <vector>
#include <iostream>
#include "esconu.h"

const int MAX = 10;
using namespace std;
int main ()
{
    BorraPantalla();
    
    vector <int> v1;
    vector <int> :: iterator iter1;
    int numero;
    // Instanciación de un vector con 10 elementos
    
    vector <int> v10Elementos;
    vector <int> v10Elementos2 (10, 35);
    vector <int> vCopia (v10Elementos);


    iter1 = v10Elementos2.begin();
    while (iter1 != v10Elementos2.end())
    {
        cout << *iter1 << "   ";
        iter1++;
    }
    cout << endl;
    

    for (int i = 0; i < MAX; i++)
    {
        cout << "Digite un dato: ";
        cin >> numero;
        v10Elementos.push_back(numero);
    }

    
    vector <int> vCopia2 (v10Elementos.begin() + 3, v10Elementos.end() - 2);
    
// Despliegue del vector usando iterador
    iter1 = vCopia2.begin();
    int i = 0;
    while (iter1 != vCopia2.end() )
    {
        cout << "Vector COPIA en la posición " << i << " = ";
        cout << *iter1 << endl;
        iter1++;
        i++;
    }
    return 0;
}
