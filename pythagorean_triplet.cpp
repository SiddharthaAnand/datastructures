//Finds all Pythagorean Triplets in a given input array of size arr_size
#include <iostream>
#include <algorithm>
#define arr_size 10

using namespace std;

void findPythagoreanTriplet(int input[])
{
    int flag = 1;
    /* Sort the array O(nlogn) */
    sort(input, input + arr_size);
    /* Square the elements and apply meet in the middle technique */
    for(int i = 0; i < arr_size; i++)
        input[i] *= input[i];
    /* fix one element and meet in the middle the other two */
    for(int third = arr_size - 1; third >= 2; third--)
    {
        int first = 0, second = third - 1;
        while(first < second)
        {
            if(input[first] + input[second] == input[third])
            {
                flag = 0;
                cout<<input[first]<<" + "<<input[second]<<" = "<<input[third]<<endl;
                //return;
            }
            (input[first] + input[second] < input[third]) ? first++ : second--;
        }
    }
    if(flag)
        cout<<"\nNo such triplet\n";
}

int main()
{
    int input[arr_size], size = 1;
    for(int i = 0; i < arr_size; i++)
    {
        cin>>input[i];
    }
    findPythagoreanTriplet(input);
}