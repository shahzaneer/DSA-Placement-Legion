// Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:

// Each student gets at least one book.
// Each book should be allocated to only one student.
// Book allocation should be in a contiguous manner.
// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1


public class maximumBookPagesAllocation {
    public static void main(String[] args) {
        int [] books = {25, 46, 28, 49, 24};
        System.out.println(maximumPagesAllocated(books, 4));
        System.out.println(maximumPagesAllocatedOptimal(books, 4));

    }

    //! Brute: TC: O() SC: O()
    static int countStudents(int [] books, int pages){
        int countStudents = 1;
        int pagesStudent = 0;
        
        for(int i=0; i<books.length;i++){
            if(pagesStudent + books[i] <= pages){
                pagesStudent+=books[i];
            }
            else{
                countStudents++;
                pagesStudent = books[i];
            }
        }

        return countStudents;
    }

    static int maximumPagesAllocated(int [] books, int students){
        if(books.length < students) return -1;

        int sum = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<books.length; i++){
            max = Math.max(max,books[i]);
            sum+= books[i];
        }

        for(int i=max; i<=sum;i++){
            if(students == countStudents(books, i)){
                return i;
            }
        }

        return -1;

    }
    //! Optimal: TC: O() SC: O()

    static int maximumPagesAllocatedOptimal(int [] books, int students){
        if(books.length < students) return -1;

        int sum = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<books.length; i++){
            max = Math.max(max,books[i]);
            sum+= books[i];
        }
        int low = max , high = sum;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(students >= countStudents(books, mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}
