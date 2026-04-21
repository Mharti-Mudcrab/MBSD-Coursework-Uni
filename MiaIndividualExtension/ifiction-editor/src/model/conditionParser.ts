import { Condition, Comparison, Operator, LogicalGroup } from "../types";

export class ConditionParser {
    public static parse(str: string): Condition | undefined {

        if (!str || str.trim() === '') return undefined;

    
        let input = str.trim();


        // Strip redundant parentehses

        while (input.startsWith('(') && input.endsWith(')') && this.isMatching(input)) {
            input = input.substring(1, input.length - 1).trim();
        }

        // Check for logical or operators first (lowest precedence)
        const orIndex = this.findLogicalOperator(input, 'or');
        if (orIndex !== -1) {
            return {
                type: 'or',
                left: this.parse(input.substring(0, orIndex)),
                right: this.parse(input.substring(orIndex + 2))
            } as LogicalGroup;
        }


        const andIndex = this.findLogicalOperator(input, 'and');
        if (andIndex !== -1) {
            return {
                type: 'and',
                left: this.parse(input.substring(0, andIndex)),
                right: this.parse(input.substring(andIndex + 3))
            } as LogicalGroup;

        }

        // If it's otherwise wrapped in parentheses, treat as parenthesized condition
        if (input.startsWith('(') && input.endsWith(')')) {
            return {
                type: 'parentheses',
                condition: this.parse(input.substring(1, input.length - 1))
            } as any;
        }

        return this.parseComparison(input);

    }


    private static findLogicalOperator(input: string, op: 'and' | 'or'): number {
        let paranLevel = 0;
        const words = input.split(/\s+/);
        let charCursor = 0;
        for (let i = 0; i < words.length; i++) {

            const word = words[i];

            for (const char of word) {
                if (char === '(') paranLevel++;
                if (char === ')') paranLevel--;
            }

            // If we're at level 0 and find op
            if (paranLevel === 0 && word.toLowerCase() === op) {
                return charCursor + input.substring(charCursor).indexOf(word);
            }

            charCursor += word.length + 1; // +1 for the space

        }

        return -1;
    }

    private static isMatching(input: string): boolean {
        let level = 0;
        for (let i = 0; i < input.length; i++) {
            if (input[i] === '(') level++;
            if (input[i] === ')') level--;
            if (level === 0 && i < input.length - 1) return false; // If we close all parentheses before the end, it's not a match
        }
        return level === 0; // All parentheses should be closed
    }

    private static parseComparison(inputStr: string): Comparison {
        const operators: Operator[] = ['==', '!=', '>=', '<=', '>', '<'];
        for (const op of operators) {

            if (inputStr.includes(op)) {
                const parts = inputStr.split(op);
                if (parts.length < 2) continue;
                const variable = parts[0].trim();
                const value = parts[1].trim();

                return {
                    type: 'comparison',
                    operator: op,
                    variable: variable.trim(),
                    value: parseInt(value.trim(), 10)
                }
            }
        }
        throw new Error(`Invalid condition: ${inputStr}`);
    }

}
