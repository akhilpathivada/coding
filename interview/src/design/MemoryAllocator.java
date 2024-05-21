/**
 * author: akhilpathivada
 * time: 21/05/24 16:23
 *
 * https://leetcode.com/problems/design-memory-allocator/
 *
 */
package design;

public class MemoryAllocator {

    private final int[] memory;

    public MemoryAllocator(int n) {
        this.memory = new int[n];
    }

    public int allocate(int size, int mID) {
        int freespaces = 0; // continuous free space
        for (int i = 0; i < memory.length; ++i) {
            if (memory[i] == 0) {
                ++freespaces;
            } else {
                freespaces = 0;
            }
            if (freespaces == size) { // found continuous freespaces
                int firstIndexOfBlock = i - size + 1;
                for (int j = firstIndexOfBlock; j <= i; ++j) {
                    memory[j] = mID;
                }
                return firstIndexOfBlock;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int freedBlocks = 0;
        for (int i = 0; i < memory.length; ++i) {
            if (memory[i] == mID) {
                memory[i] = 0;
                ++freedBlocks;
            }
        }
        return freedBlocks;
    }

    public static void main(String[] args) {

    }
}
