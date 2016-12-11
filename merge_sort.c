#include <stdio.h>
#include <stdlib.h>

void merge_sort(int *, int *, int, int);
void merge(int *, int *, int, int, int);
void print(int *, int);

void merge_sort(int *input_numbers, int *temp, int begin, int end)
{
	int mid;
	if(begin < end)
	{
		mid = begin + (end - begin) /2;
		merge_sort(input_numbers, temp, begin, mid);
		merge_sort(input_numbers, temp, mid + 1, end);
		merge(input_numbers, temp, begin, mid, end);
		print(input_numbers, end);
	}
}

void merge(int *input_numbers, int *temp, int begin, int mid, int end)
{
	int left_end = mid - 1, index = 0, k;

	while((begin <= left_end) && (mid <= end))
	{
		if(input_numbers[begin] <= input_numbers[mid])
		{
			temp[index++] = input_numbers[begin++];
		}
		else
		{
			temp[index++] = input_numbers[mid++];
		}
	}

	while(begin <= left_end)
		temp[index++] = input_numbers[begin++];
	
	while(mid <= end)
		temp[index++] = input_numbers[mid++];
	
	for(k = begin; k <= end; k++)
	{
		input_numbers[k] = temp[k];
		 
	}
}

void print(int *array, int size)
{
	int i;
	for(i = 0; i < size; i++)
		printf("%d ", array[i]);
	printf("\n");
}

int main()
{
	int *input_numbers, *temp, i = 0;
	int size;

	scanf("%u", &size);
	if(size < 1)
	{
		printf("\nEnter a valid size\n");
		exit(-1);
	}
	input_numbers = (int *)malloc(sizeof(int) * size);
	temp = (int *)malloc(sizeof(int) * size);
	while(i != size)
		scanf("%d", &input_numbers[i++]);

	merge_sort(input_numbers, temp, 0, size-1);
	printf("\nSorted Array\n");
	print(input_numbers, size);

}