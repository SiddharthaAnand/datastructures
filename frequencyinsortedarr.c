/* 
 * Find the frequency of a given number in a sorted array in O(log N) complexity.
 */

#include <stdio.h>

//Find the left most and right most positions of the value and return the difference plus 1.

int leftmost_posn(int arr[], int left, int right, int x)
{
	int mid = -1, pos = -1;
	while(left <= right)
	{
		mid = (left + right) / 2;
		if(arr[mid] >= x)
		{
			pos = mid;
			right = mid - 1;
		}
		else
			left = mid + 1;	
	}
	if(pos != -1 && arr[pos] == x)
		return pos;
	return -1;
}

//Find the right most position of the value and return the difference plus 1.

int rightmost_posn(int arr[], int left, int right, int x)
{
	int mid = -1, pos = -1;
	while(left <= right)
	{
		mid = (left + right) / 2;
		if(arr[mid] <= x)
		{
			pos = mid;
			left = mid + 1;
		}
		else
			right = mid - 1;	
	}
	if(pos != -1 && arr[pos] == x)
		return pos;
	return -1;
}

int binary_search(int arr[], int x)
{
	
}

int main()
{
	//Assuming 10 values taken in the sorted array. Input needs to be sorted.
	int arr[10], i = 0, x;
	while(i < 10)
	{
		scanf("%d", &arr[i]);
		i++;
	}

	//x is the value to be searched in the array. 
	//Returns -1 if the value is not present in the array.
	scanf("%d", &x);

	//The difference between the (positions + 1) is the frequency of the value x.
	printf("\nLeftmost Position of %d: %d\n", x, leftmost_posn(arr, 0, 9, x));
	printf("\nRightmost Position of %d: %d\n", x, rightmost_posn(arr, 0, 9, x));

}
