//Codeforces : BerSU Ball : two-pointer algorithm

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int noBoys, noGirls;
	cin >> noBoys;
	vector<int> boys(noBoys);
	for(int i = 0; i < noBoys; i++)
		cin >> boys[i];
	cin >> noGirls;
	vector<int> girls(noGirls);
	for(int i = 0; i < noGirls; i++)
		cin >> girls[i];

	sort(boys.begin(), boys.end());
	sort(girls.begin(), girls.end());
	int pairs = 0, i = 0, j = 0;
	
	while(i < noBoys && j < noGirls) {
		if(abs(boys[i] - girls[j]) <= 1) {
				pairs++;
				i++;
				j++;
			}
			else if(boys[i] - girls[j] > 1)
				j++;
			else
				i++;
	}
	cout << pairs << endl;
	return 0;
}