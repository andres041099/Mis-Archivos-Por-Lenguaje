#include <vector>
#include <utility>
#include <iostream>
#include <esconu.h>
#include <algorithm> 

using namespace std;

void ver( vector<pair<string, int> > );


int main(void)
{
    BorraPantalla();
    
    
	int cantidad, edad;
	string nombre;
	
	pair <string, int> a;
    
	vector <pair <string, int> > v; // Debe haber ser asi "> >"
	
	cout << endl << endl << "=> Cuantos pares ?: ";
	cin >> cantidad;
	
	cout << endl << endl << "=> Entre los pares (nombre, edad):" << endl << endl;

	for(int i = 0; i < cantidad; ++i)
	{
		cin >> nombre >> edad;
		v.push_back (  make_pair(nombre, edad)  );	// make_pair retorna un pair
												// make_pair crea un pair<string, int>
												// que luego es inyectado al <vector>
	}
	
	cout << "\n=> Los pares almacenados son:\n";
	ver(v);
	
	sort(v.begin(), v.end());					// clasifica usando la coordenada x                     
	
	cout << "\n=> Los pares almacenados ordenados son:\n";
	ver(v);
	
	return 0;
}



void ver( vector<pair<string, int> > v)
{
	cout << endl << endl;
	
	vector < pair <string, int> > :: iterator iter;
    
    iter = v.begin();
	
	while( iter != v.end() )
	{
		// cout << (*iter).first << "   " << (*iter).second << endl;
		
		cout << iter->first << "   " << iter->second << endl;
		iter++;
	}
}

