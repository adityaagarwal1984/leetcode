# Write your MySQL query statement below
-- ^ anchors to start of string
-- [a-zA-Z] ensures first character is a letter
-- [a-zA-Z0-9_.-]* allows any combination of letters, digits, _, ., - after first char
-- @leetcode\.com$ ensures exact domain match (escaped dot with \.)
-- $ anchors to end of string
SELECT *
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$'
and mail like binary '%@leetcode.com';
