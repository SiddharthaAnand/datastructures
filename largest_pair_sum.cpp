#include <iostream>
#include <algorithm>
//#define arr_size 5

using namespace std;

void largest_pair_sum(int input[], int arr_size)
{
	int lar = max(input[0], input[1]), slar = min(input[0], input[1]);
	for(int i = 2; i < arr_size; i++)
	{
		if(lar < input[i])
		{
			slar = lar;
			lar = input[i];
		}
	}
	cout<<"\nLargest "<<lar<<"\nSecond Largest "<<slar<<endl;
	cout<<"Max Pair Sum = "<<lar + slar<<endl;
}

int main()
{
	int size = 0, arr_size; 
	cout<<"\nEnter the array size : ";
	cin>>arr_size;
	int input[arr_size];
	while(size < arr_size)
	{
		cin>>input[size++];
	}
	if(arr_size == 0)
	{
		cout<<"\nEnter valid array size"<<endl;
		return 0;
	}
	if(arr_size == 1)
	{
		cout<<"\nSingle Element Largest "<<input[0]<<endl;
		return 0;
	}
	if(arr_size == 2)
	{
		cout<<"\nLargest "<<max(input[0], input[1])<<endl;
		cout<<"Second Largest "<<min(input[0], input[1])<<endl;
		cout<<"pair Sum "<<input[0] + input[1]<<endl;
		return 0;
	}
	
	largest_pair_sum(input, arr_size);

}