#include <iostream>
#include <algorithm>
#define arr_size1 6
#define arr_size2 5

using namespace std;

void intersection_of_arrays(int input1[], int input2[])
{
	int output[min(arr_size1, arr_size2)], index1 = 0, index2 = 0, index3 = 0;
	sort(input1, input1 + arr_size1);
	sort(input2, input2 + arr_size2);

	while(index1 < arr_size1 && index2 < arr_size2)
	{
		if(input1[index1] == input2[index2])
		{
			output[index3++] = input1[index1];
			(index2++, index1++);
			continue;
		}
		(input1[index1] < input2[index2]) ? index1++ : index2++;
	}
	
	/* Print the output */
	cout<<"Intersection\n";
	for(int i = 0; i < index3; i++)
		cout<<output[i]<<" ";
	cout<<endl;
}

void union_of_arrays(int input1[], int input2[])
{
	int output[(arr_size1 + arr_size2)], index1 = 0, index2 = 0, index3 = 0;
	sort(input1, input1 + arr_size1);
	sort(input2, input2 + arr_size2);

	while(index1 < arr_size1 && index2 < arr_size2)
	{
		if(input1[index1] == input2[index2])
		{
			output[index3++] = input1[index1];
			(index1++, index2++);
			continue;
		}
		output[index3++] = ((input1[index1] < input2[index2]) ?	input1[index1++] : input2[index2++]);
	}

	if(index1 == arr_size1)
	{
		while(index2 < arr_size2)
			output[index3++] = input2[index2++];
	}
	else
	{
		while(index1 < arr_size1)
			output[index3++] = input2[index1++];
	}

	cout<<"Union\n";
	for(int i = 0; i < index3; i++)
		cout<<output[i]<<" ";
	cout<<endl;
}

int main()
{
	int input1[arr_size1], input2[arr_size2], size = 0;

	cout<<"\nEnter the first array\n";
	while(size < arr_size1)
	{
		cin>>input1[size];
		size++;
	}
	size = 0;
	
	cout<<"\nEnter the second array\n";
	while(size < arr_size2)
	{
		cin>>input2[size];
		size++;
	}
	
	intersection_of_arrays(input1, input2);
	union_of_arrays(input1, input2);
}