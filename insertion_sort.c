#include <stdio.h>
#include <stdlib.h>

void insertion_sort(int *, int);
void print(int *, int);

void insertion_sort(int *input_numbers, int size)
{
	int index;
	for(index = 1; index < size; index++)
	{
		int temp = input_numbers[index];
		int k = index - 1;
		while(k >= 0 && input_numbers[k] > temp)
		{
			input_numbers[k+1] = input_numbers[k];
			k--;
		}
		print(input_numbers, size);
		input_numbers[k+1] = temp;
		print(input_numbers, size);
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
	int *input_numbers, i = 0;
	int size;

	scanf("%u", &size);
	if(size < 1)
	{
		printf("\nEnter a valid size\n");
		exit(-1);
	}
	input_numbers = (int *)malloc(sizeof(int) * size);
	while(i != size)
		scanf("%d", &input_numbers[i++]);
	insertion_sort(input_numbers, size);
	printf("\nSorted Array\n");
	print(input_numbers, size);

}