//Codeforces : Sereja and Dima : two-pointer algorithm

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int noCards, serejaScore = 0, dimaScore = 0;
	cin >> noCards;
	vector<int> input(noCards);
	for(int i = 0; i < noCards; i++)
		cin >> input[i];

	int i = 0, count = 0, j = input.size() - 1;
	while(i <= j) {
		if(count % 2 == 0) {
			serejaScore += (input[i] > input[j] ? input[i] : input[j]);
			if(input[i] > input[j])
				i++;
			else
				j--;
		}
		else {
			dimaScore += (input[i] > input[j] ? input[i] : input[j]);
			if(input[i] > input[j])
				i++;
			else
				j--;
		}
		count++;
	}
	cout << serejaScore << " " << dimaScore << endl;
	return 0;
}