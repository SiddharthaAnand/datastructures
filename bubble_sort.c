#include <stdio.h>
#include <stdlib.h>

void bubble_sort(int *, int);
void print(int *, int);

void bubble_sort(int *input_numbers, int size)
{
	int index_1, index_2;
	
	for(index_1 = 0; index_1 < size-1; index_1++)
	{
		for(index_2 = 0; index_2 < size-1; index_2++)
		{
			if(input_numbers[index_2] > input_numbers[index_2+1])
			{
				(input_numbers[index_2] ^= input_numbers[index_2+1], \
				input_numbers[index_2+1] ^= input_numbers[index_2], \
				input_numbers[index_2] ^= input_numbers[index_2+1]);
			}
		}
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
	bubble_sort(input_numbers, size);
	printf("\nSorted Array\n");
	print(input_numbers, size);

}